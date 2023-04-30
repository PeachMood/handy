import { useEffect } from 'react';
import {
  Axios, AxiosError, AxiosResponse, InternalAxiosRequestConfig,
} from 'axios';

import { useAxios } from 'hooks/axios/useAxios';
import { useAuthContext } from 'hooks/context/useAuthContext';
import { useAuthApi } from 'hooks/api/useAuthApi';

type OriginalRequest = InternalAxiosRequestConfig & { isRetry?: boolean };

export const useAxiosPrivate = (): Axios => {
  const axios = useAxios();
  const authApi = useAuthApi();
  const { accessToken, setAccessToken } = useAuthContext();

  useEffect(() => {
    const onRequest = (config: InternalAxiosRequestConfig): InternalAxiosRequestConfig => {
      const request = config;
      request.headers.Authorization = `Bearer ${accessToken}`;
      return request;
    };

    const onRequestError = (error: AxiosError): Promise<AxiosError> => Promise.reject(error);

    const onResponse = (response: AxiosResponse): AxiosResponse => response;

    const onResponseError = async (error: AxiosError): Promise<AxiosResponse> => {
      const originalRequest: OriginalRequest = error.config;
      if (error.response?.status === 401 && !originalRequest?.isRetry) {
        originalRequest.isRetry = true;
        const response = await authApi.refreshToken();
        setAccessToken(response.data?.accessToken);
        return axios.request(originalRequest);
      }
      return Promise.reject(error);
    };

    const requestInterceptor = axios.interceptors.request.use(onRequest, onRequestError);
    const responseInterceptor = axios.interceptors.response.use(onResponse, onResponseError);

    return () => {
      axios.interceptors.request.eject(requestInterceptor);
      axios.interceptors.request.eject(responseInterceptor);
    };
  }, [axios, authApi]);

  return axios;
};
