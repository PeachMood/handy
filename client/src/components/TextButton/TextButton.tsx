import React, { FC, ButtonHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './TextButton.module.scss';

export interface TextButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large' | 'small' | 'huge';
}

export const TextButton: FC<TextButtonProps> = ({
  color = 'primary', size = 'medium', className, ...props
}) => {
  const classes = classNames(
    styles.textButton,
    styles[color],
    styles[size],
    className,
  );

  return <button className={classes} {...props} />;
};
