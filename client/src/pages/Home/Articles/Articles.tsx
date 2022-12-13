import React from 'react';

import { initialArticlesContent } from 'utils/constants';

import { ArticleContent } from 'types/types';
import { ArticleProps, Article } from './Article/Article';

export const Articles = (): JSX.Element => {
  const renderArticle = (articleContent: ArticleContent, index: number): JSX.Element => {
    const articleProps: ArticleProps = {
      content: articleContent,
      theme: index % 2 === 0 ? 'light' : 'dark',
      side: index % 2 === 0 ? 'left' : 'right',
    };
    return <Article key={articleContent.title} {...articleProps} />;
  };

  return (
    <section aria-label="Advantages of Handy">
      {initialArticlesContent.map(renderArticle)}
    </section>
  );
};
