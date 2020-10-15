# -*- coding: utf-8 -*- 
from flask import Flask, render_template, redirect, request, url_for, jsonify
from flask_restful import Resource, Api
from detail_topic import detail_topic
import json
import pandas as pd

app = Flask(__name__)
#api = Api(app)
app.config['JSON_AS_ASCII'] = False

#@app.route('/')
#def keyword():
#	return render_template('main.html')

@app.route('/field', methods=['POST'])
def field():
	value = request.get_json(silent=True)
	print(value)
	#value = json.dumps(value, ensure_ascii=False)
	#value = request.args.get('field')
	if value['field'] == 'politics':
		file = pd.read_csv('20200508_data.csv')
	elif value['field'] == 'economics':
		file = pd.read_csv('20200519_economic_news_data.csv')

	remove_list = ['최강시사', '시선집중', '노영희']
	for i in remove_list:
	    idx =  file[file.title.str.contains(i)].index
	    file = file.drop(idx)
	keyword_name = file.drop_duplicates(['keyword'], keep='first')['keyword'].reset_index(drop=True, inplace=False)
	keyword_name = keyword_name.to_dict()
	json_key = json.dumps(keyword_name, ensure_ascii=False)
	return json_key

@app.route('/keyword',methods=['POST'])
def keyword():
    value = request.get_json(silent=True)
    result = detail_topic(value['field'], value['keyword'])
    #result = result.to_dict()
    json_result = json.dumps(result, ensure_ascii=False)
    return json_result

@app.route('/image', methods=['POST'])
def image():
	value = request.get_json(silent=True)
	field = value['field']
	keyword = value['keyword']
	#topic_num = value['topic_num']
	return ''
 
if __name__ == '__main__':
    app.run()