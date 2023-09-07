import { useAuthApi } from 'hooks/api/useAuthApi';
import React, {
  createContext, useState, FC, useMemo, useEffect,
} from 'react';
import { useNavigate } from 'react-router-dom';

interface AuthContext {
  accessToken: string;
  isLoggedIn: boolean;
  setAccessToken: (accessToken: string) => void;
  setIsLoggedIn: (isLoggedIn: boolean) => void;
}

export const AuthContext = createContext<AuthContext>(null);

export const AuthProvider: FC = ({ children }) => {
  const [accessToken, setAccessToken] = useState<string>(null);
  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(true);
  const navigate = useNavigate();
  const authApi = useAuthApi();

  const value = useMemo(() => ({
    accessToken, isLoggedIn, setIsLoggedIn, setAccessToken,
  }), [accessToken, isLoggedIn, setIsLoggedIn, setAccessToken]);

  useEffect(() => {
    const checkToken = async () => {
      try {
        const response = await authApi.refreshToken();
        setAccessToken(response.data?.accessToken);
        setIsLoggedIn(true);
        navigate('/notes', { replace: true });
      } catch (error) {
        if (error.response?.status === 401) {
          // with this redirect new user (without saved refresh token)
          // can't open main page
          // navigate('/login', { replace: true });
        } else {
          console.log(error);
        }
      }
    };

    checkToken();
  }, []);

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  );
};
