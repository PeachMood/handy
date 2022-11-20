import React from 'react';
import ReactDOM from 'react-dom/client';
import { App } from './routes/App';

const root = document.getElementById('root') as HTMLElement;
const react = ReactDOM.createRoot(root);
react.render(<App/>);
