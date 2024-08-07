import React from 'react';
import styles from './maininput.module.css';
function MainInput() {
  return (
    <div className={styles.maininpute}>
      <div className={styles.topInpute}>
        <label>Icon</label>
        <select></select>
        <label>Text</label>
        <input />
      </div>
    </div>
  );
}

export default MainInput;
