import React from 'react';

import logo from 'assets/images/logo.svg';

import styles from './Logo.module.scss';

export const Logo = (): JSX.Element => <img className={styles.logo} src={logo} alt="Handy" />;
