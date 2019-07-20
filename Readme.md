docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:6.6.2
docker run -d --name elastichq -p 5000:5000 elastichq/elasticsearch-hq