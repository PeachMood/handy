import { AxiosResponse } from 'axios';

import { useAxios } from 'hooks/axios/useAxios';

export interface AuthResponse {
  tokenType: string;
  expiresIn: number;
  accessToken: string;
  refreshToken: string;
}

export interface AuthApi {
  refreshToken: () => Promise<AxiosResponse<AuthResponse>>;
  login: (username: string, password: string) => Promise<AxiosResponse<AuthResponse, any>>
}

export const useAuthApi = (): AuthApi => {
  const axios = useAxios();

  const refreshToken = async (): Promise<AxiosResponse<AuthResponse, any>> => axios.get<AuthResponse>('/auth/refresh-token');

  const login = async (username: string, password: string): Promise<AxiosResponse<AuthResponse>> => axios.post<AuthResponse>('/auth/login', { username, password });

  return { refreshToken, login };
};
