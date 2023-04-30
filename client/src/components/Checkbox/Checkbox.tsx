import React, { forwardRef, InputHTMLAttributes } from 'react';
import classNames from 'classnames';

import styles from './Checkbox.module.scss';

export interface CheckboxProps extends InputHTMLAttributes<HTMLInputElement> {
  label?: string;
}

export const Checkbox = forwardRef<HTMLInputElement, CheckboxProps>((props, ref) => {
  const { label, className, ...otherProps } = props;
  return (
    <label className={classNames(styles.label, className)}>
      <input type="checkbox" className={styles.checkbox} ref={ref} {...otherProps} />
      <span className={styles.span} />
      {label}
    </label>
  );
});
