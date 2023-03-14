import React from 'react';
import { Route, Routes } from 'react-router-dom';

import { Home } from './pages/Home/Home';

import './App.scss';

export const App = (): JSX.Element => (
  <Routes>
    <Route path="/" element={<Home />} />
  </Routes>
);
