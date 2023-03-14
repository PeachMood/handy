FROM node:18.12.1-alpine
WORKDIR /client
ADD . .
ENV NODE_ENV=production
RUN npm install
# A temporary solution for a working build of the frontend
RUN npm rebuild node-sass
CMD npm run build
