import React, { FC, AnchorHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './Link.module.scss';

export interface LinkProps extends AnchorHTMLAttributes<HTMLAnchorElement> {
  color?: 'primary' | 'accent';
  size?: 'medium' | 'large' | 'small';
}

export const Link: FC<LinkProps> = ({
  color = 'primary', size = 'medium', className, href, children, ...props
}) => {
  const classes = classNames(
    styles.link,
    styles[color],
    styles[size],
    className,
  );

  return <a href={href} className={classes} {...props}>{children}</a>;
};
