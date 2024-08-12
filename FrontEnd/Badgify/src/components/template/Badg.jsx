import React from 'react';
import styles from './badg.module.css';
function Badg() {
  return (
    <div className={styles.main}>
      <div className={styles.sidbar}>sidbar</div>
      <div className={styles.badg}>
        <div className={styles.container}>
          <div className={styles.badgbtn}>
            <input placeholder="search" />
            <button>CREATE CUSTOMIZED BADGE</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Badg;
