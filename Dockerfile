FROM node

# create app directory
WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8080

RUN ["npm", "start"]


