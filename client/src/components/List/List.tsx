import React, { Children, FC, HTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './List.module.scss';

export interface ListProps extends HTMLAttributes<HTMLUListElement> {
  listStyles?: string,
  itemStyles?: string,
}

export const List: FC<ListProps> = ({
  listStyles, itemStyles, children, ...props
}) => {
  const items = Children.map(children, (child) => (
    <li className={classNames(styles.item, itemStyles)}>{child}</li>
  ));

  return (
    <ul className={classNames(styles.list, listStyles)} {...props}>
      {items}
    </ul>
  );
};
