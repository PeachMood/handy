import React, { FC } from 'react';

import { Article } from './Article/Article';
import { initialArticles } from './constants';

export const Articles: FC = () => (
  <section aria-label="advantages of handy">
    {initialArticles.map((article) => <Article key={article.title} {...article} />)}
  </section>
);
