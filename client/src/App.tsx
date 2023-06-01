import React, { FC } from 'react';

import { GlobalProvider } from 'contexts/GlobalContext';
import { Router } from 'routes/Router';

import './App.scss';

export const App: FC = () => (
  <GlobalProvider>
    <Router />
  </GlobalProvider>
);
