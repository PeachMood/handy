import React, { FC } from 'react';
import { Routes, Route } from 'react-router-dom';

import { Home } from 'pages/Home/Home';
import { Login } from 'pages/Login/Login';
import { Register } from 'pages/Register/Register';
import { Notes } from 'pages/Notes/Notes';
import { NotFound } from 'pages/NotFound/NotFound';
import { PrivateRoute } from 'routes/PrivateRoute';
import { PublicRouter } from 'routes/PublicRouter';

export const Router: FC = () => (
  <Routes>
    <Route element={<PublicRouter />}>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
    </Route>
    <Route element={<PrivateRoute />}>
      <Route path="/notes" element={<Notes />} />
    </Route>
    <Route path="*" element={<NotFound />} />
  </Routes>
);
