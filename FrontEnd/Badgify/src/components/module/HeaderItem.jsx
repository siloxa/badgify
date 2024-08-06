import React from 'react';
import { NavLink } from 'react-router-dom';
import styles from './headerItem.module.css';

function HeaderItem({ children, to }) {
  return (
    <div>
      <NavLink to={to}  className={({ isActive }) => isActive ? `${styles.navLink} ${styles.active}` : styles.navLink}>
        {({ isActive }) => (
          <div className={styles.flexDoted}>
            {children}
            {isActive && <span className={styles.activeIndicator}>●</span>}
          </div>
        )}
      </NavLink>
    </div>
  );
}

export default HeaderItem;
