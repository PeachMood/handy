import axios, { Axios } from 'axios';

export const useAxios = (): Axios => axios.create({
  baseURL: window.location.hostname === 'localhost' ? 'http://localhost:8080/api' : 'https://handy-notes.ru/api',
  withCredentials: true,
});
