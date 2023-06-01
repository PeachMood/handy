import React, { FC, LiHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './MenuItem.module.scss';

interface MenuItemProps extends LiHTMLAttributes<HTMLLIElement> {
  icon: string;
  text: string;
  type?: 'delete';
}

export const MenuItem: FC<MenuItemProps> = ({
  icon, text, type, className, ...props
}) => {
  const itemStyles = classNames(styles.item, styles[type], className);

  return (
    <li className={itemStyles} {...props}>
      <div className={styles.icon} style={{ backgroundImage: `url(${icon})` }} />
      <span className={styles.text}>{text}</span>
    </li>
  );
};
