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
  login: (username: string, password: string) => Promise<AxiosResponse<AuthResponse>>
  register: (username: string, email: string, password: string) => Promise<AxiosResponse<void>>
}

export const useAuthApi = (): AuthApi => {
  const axios = useAxios();

  const refreshToken = async (): Promise<AxiosResponse<AuthResponse>> => axios.get<AuthResponse>('/auth/refresh-token');

  const login = async (username: string, password: string): Promise<AxiosResponse<AuthResponse>> => axios.post<AuthResponse>('/auth/login', { username, password });

  const register = async (username: string, email: string, password: string): Promise<AxiosResponse<void>> => axios.post<void>('/auth/register', { username, email, password });

  return { refreshToken, login, register };
};
