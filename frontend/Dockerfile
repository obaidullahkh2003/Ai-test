FROM node:22-alpine AS build
WORKDIR /app
COPY package.json angular.json tsconfig*.json ./
COPY src ./src
RUN npm install && npm run build

FROM nginx:1.27-alpine
COPY --from=build /app/dist/browser /usr/share/nginx/html
EXPOSE 80
