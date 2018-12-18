FROM node:7
WORKDIR /app
COPY package.json /app
RUN npm install
copy . /app
CMD node myapp.js
EXPOSE 3009
