import React from 'react';
import classNames from 'classnames';

import styles from './List.module.scss';

interface ListProps extends React.ButtonHTMLAttributes<HTMLUListElement> {
  listStyles?: string,
  itemStyles?: string,
}

export const List = ({
  listStyles, itemStyles, children, ...props
}: ListProps): JSX.Element => (
  <ul className={classNames(styles.list, listStyles)} {...props}>
    {React.Children.map(children, (child) => (
      <li className={classNames(styles.item, itemStyles)}>{child}</li>
    ))}
  </ul>
);
