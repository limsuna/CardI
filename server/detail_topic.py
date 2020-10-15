# gensim modules
from gensim import utils
from gensim.models.doc2vec import LabeledSentence
from gensim.models import Doc2Vec

# numpy
import numpy

# random
from random import shuffle
# classifier
from sklearn.linear_model import LogisticRegression
import pandas as pd
from sklearn.cluster import KMeans
# common_text에는 파싱된 워드 리스트들이 들어가 있음.
from gensim.test.utils import common_texts
# Doc2Vec이 우리가 텍스트를 사용해서 학습되는 모델(뉴럴넷)이고 
# TaggedDocument가 넘겨주는 텍스트들. 
# 여기서, corpus와 ID들을 함께 넘겨줘야 하는데, 여기서 ID는 tag와 같은 말임
# Q: 여기서, 여러 tag를 함께 넘겨준 다음, 적합한 태그를 찾아주는 방식으로도 처리할 수 있는지 파악하는 것이 필요함. 
from gensim.models.doc2vec import Doc2Vec, TaggedDocument
from konlpy.tag import Kkma
kkma = Kkma()
from konlpy.tag import Okt  
okt=Okt()
from konlpy.tag import Mecab # KoNLPy style mecab wrapper
mecab = Mecab()

#그래프
from scipy.cluster.hierarchy import linkage, dendrogram
import matplotlib.pyplot as plt
import scipy.cluster.hierarchy as sch

from keras.models import load_model
import scipy.cluster.hierarchy as sch

from numpy import dot
from numpy.linalg import norm
import numpy as np

def cos_sim(A, B):
       return dot(A, B)/(norm(A)*norm(B))

def similarity_matrix(X) :

    total_similarity = []

    for i in X :
        s_list = []
        for j in X :
            s_list.append(cos_sim(i,j))
        total_similarity.append(s_list)

    return total_similarity


def detail_topic(field, key):
    model = Doc2Vec.load("pretrained.model")
    if field == 'politics':
        politics = pd.read_csv('20200508_data.csv')
    elif field == 'economics':
        politics = pd.read_csv('20200519_economic_news_data.csv')

    remove_list = ['최강시사', '시선집중', '노영희']
    for i in remove_list:
        idx =  politics[politics.title.str.contains(i)].index
        politics = politics.drop(idx)

    keyword = politics[politics['keyword']==key]
    keyword = keyword.dropna()
    keyword = keyword.reset_index(drop=True, inplace=False)

    news_text = keyword['news_text']
    news_title = keyword['title']

    idx = politics.index

    _texts=[]
    _titles=[]

    for i in news_text :
        _texts.append(mecab.nouns(i))

    for i in news_title :
        _titles.append(mecab.nouns(i))

    _tags = [] 
    for j in idx:
        _tags.append([j])

    titles_and_tags = [] # idx, title 조합
    texts_and_tags = [] # idx, text 조합

    for i in range(len(_titles)):
        titles_and_tags.append((_titles[i], _tags[i]))
        texts_and_tags.append((_texts[i], _tags[i]))

    v_list=[]
    for i in _texts: # 불러온 모델에 뉴스 텍스트 넣어서 infer
        t_vec=model.infer_vector(i)
        v_list.append(t_vec)

    issue_lis = v_list

    # Calculate the linkage: mergings : 전체 data
    d = sch.distance.pdist(issue_lis)   # vector of (100 choose 2) pairwise distances
    L = sch.linkage(d, method='ward')

    # Plot the dendrogram, using varieties as labels
    '''plt.figure(figsize=(40,20))
    dendrogram(L,
               #labels = labels.as_matrix(columns=['labels']),
               leaf_rotation=90,
               leaf_font_size=20,
    )
    plt.show()'''

    ind = sch.fcluster(L, 0.4*d.max(), 'distance')
    #t -> 1에 가까워질수록 상위 클래스로 설정됨

    import numpy as np # 모든 그룹의 기사 모음

    grp = ind.tolist()
    grp_n = max(ind)

    tmp = []
    topic_set = []
    #토픽별 문서 정렬 - topic set
    for n in range(1, grp_n+1):
        for i in range(0, len(grp)):
            if grp[i] == n:
                tmp.append(i)
        topic_set.append(tmp) 
        tmp = []

    #토픽 별 벡터 저장
    vector = []
    topic_vec = []
    a = 0
    for n in range(0, grp_n):
        for i in range(0, len(topic_set[a])):
            vector.append(issue_lis[topic_set[n][i]].tolist())
        a+=1
        topic_vec.append(vector)
        vector = []
    topic_vec = np.array(topic_vec)


    #토픽별 네트워크 -> 대표기사 출력
    import networkx as nx
    from operator import itemgetter
    top_list = []
    pagerank_list=[]

    for m in range(0, grp_n):
        similarity = similarity_matrix(topic_vec[m])
        dg = nx.Graph()
        dg.add_nodes_from(topic_set[m])

        for i in range(0, len(similarity)):
            for j in range(i, len(similarity)):
                #print(i, j)
                dg.add_edge(topic_set[m][i], topic_set[m][j], weight = similarity[i][j])

        pagerank = nx.pagerank(dg)
        pagerank_list.append(list(pagerank.keys()))
        top_grp = max(pagerank.items(), key=itemgetter(1))[0]
        top_list.append(top_grp)
        #draw_graph(dg)

    top_list= sorted(top_list, reverse=True)
    topic = {}

    #대표기사 출력
    for i in range(0, len(top_list)):
        topic[i] = keyword['title'][top_list[i]]
        '''print("------------------------------------------------------")
        print("그룹 " + str(i) + " 의 대표기사")
        print(keyword['title'][top_list[i]])'''
    
    return topic