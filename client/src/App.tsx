import React, { FC } from 'react';

import { AuthProvider } from 'contexts/AuthContext';
import { Router } from 'routes/Router';

import './App.scss';

export const App: FC = () => (
  <AuthProvider>
    <Router />
  </AuthProvider>
);
