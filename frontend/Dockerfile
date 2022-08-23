FROM node:10.19.0

# Create app directory
WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

RUN chown -R node: /usr/src/app

USER node

EXPOSE 8080

CMD ["npm", "run", "serve"]
