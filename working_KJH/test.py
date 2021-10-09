import requests
import json

client_id = "f0tc0p4p3mifcdxtwi530swm2dsw0f"
next_cursor = ""
params = {}
params['client_id'] = client_id

chat_log = []
log_cnt = 0

# URL = "https://api.twitch.tv/v5/videos/1169919367/comments?cursor="""
URL = "https://api.twitch.tv/v5/tmxk319"

response = requests.get(URL, params=params)
chat_json = json.loads(response.text)
print(chat_json)
