docker run -dp 3000:3000
  -w /SCCHOOL_SITE_SERVER -v ${PWD}:/SCCHOOL_SITE_SERVER
  --network dev_school_db
  -e MYSQL_HOST=mysql
  -e MYSQL_USER=root
  -e MYSQL_PASSWORD=root
  -e MYSQL_DB=dev_school_db
  node:12-alpine
  sh -c "yarn install && yarn run dev"