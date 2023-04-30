import React, { FC } from 'react';
import classNames from 'classnames';

import styles from './Article.module.scss';

export interface ArticleProps {
  title: string;
  subtitle: string;
  image: Image;
  theme?: 'dark' | 'light';
  side?: 'left' | 'right';
  className?: string;
}

export const Article: FC<ArticleProps> = ({
  title, subtitle, image, theme = 'light', side = 'right', className,
}) => {
  const classes = classNames(
    styles.article,
    styles[theme || 'light'],
    styles[side || 'left'],
    className,
  );

  return (
    <article className={classes}>
      <div>
        <h2 className={styles.title}>{title}</h2>
        <p className={styles.subtitle}>{subtitle}</p>
      </div>
      <div className={styles.imageContainer}>
        <img className={styles.image} src={image.src} alt={image.alt} />
      </div>
    </article>
  );
};
