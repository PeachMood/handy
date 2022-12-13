import React from 'react';
import classNames from 'classnames';

import { Image } from 'types/types';

import styles from './IconButton.module.scss';

interface IconButtonProps extends React.AnchorHTMLAttributes<HTMLAnchorElement> {
  image: Image;
}

export const IconButton = ({ image, className, ...props }: IconButtonProps): JSX.Element => {
  const classes = classNames(styles.iconButton, className);

  return (
    <a className={classes} {...props}>
      <img className={styles.icon} src={image.src} alt={image.alt} />
    </a>
  );
};
