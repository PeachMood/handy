import React from 'react';
import { hydrate } from 'react-dom';
import { renderToString } from 'react-dom/server';
import { BrowserRouter } from 'react-router-dom';
import { StaticRouter } from 'react-router-dom/server';

import { App } from './App';

const global: any = window;

// Called only in the browser
// If there is html rendered on the server, adds only event listeners to it
global.renderClient = () => {
  hydrate(
    <BrowserRouter>
      <App />
    </BrowserRouter>,
    document.getElementById('root'),
  );
};

// Called only on the server
// The result is inserted into html via the content attribute
// Defines the html structure and its appearance
global.renderServer = () => renderToString(
  <StaticRouter location={global.requestURI}>
    <App />
  </StaticRouter>,
);
