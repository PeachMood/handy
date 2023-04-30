import React, { FC, ButtonHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './IconButton.module.scss';

export interface IconButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  image: string;
}

export const IconButton: FC<IconButtonProps> = ({ image, className, ...props }) => (
  <button
    className={classNames(styles.button, className)}
    style={{ backgroundImage: `url(${image})` }}
    {...props}
  />
);
