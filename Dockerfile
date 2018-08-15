FROM node

RUN mkdir /src

# create app directory
WORKDIR /src
ADD app/package.json /src/package.json
RUN npm install

EXPOSE 8080

CMD npm start