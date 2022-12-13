import React from 'react';
import classNames from 'classnames';

import { ArticleContent } from 'types/types';

import styles from './Article.module.scss';

export interface ArticleProps {
  content: ArticleContent;
  theme?: 'dark' | 'light';
  side?: 'left' | 'right';
  className?: string;
}

export const Article = ({
  content, theme = 'light', side = 'left', className,
}: ArticleProps): JSX.Element => {
  const classes = classNames(
    styles.article,
    styles[theme],
    styles[side],
    className,
  );

  return (
    <article className={classes}>
      <div>
        <h2 className={styles.title}>{content.title}</h2>
        <p className={styles.subtitle}>{content.subtitle}</p>
      </div>
      <div className={styles.imageContainer}>
        <img className={styles.image} src={content.image.src} alt={content.image.alt} />
      </div>
    </article>
  );
};
