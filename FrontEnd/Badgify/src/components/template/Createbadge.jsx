import React from 'react';
import styles from './createbadge.module.css';

function Createbadge() {
  return (
    <div className={styles.container}>
      <form className={styles.form}>
        <div className={styles.inputcon}>
          <div className={styles.inputmain}>
            <label>Type</label>
            <select></select>
          </div>
          <div className={styles.inputmain}>
            <label>Theme</label>
            <select></select>
          </div>
        </div>
        <div className={styles.inputcon}>
          <div className={styles.inputmain}>
            <label>Color</label>
            <input placeholder="Type hex code or color’s name" />
          </div>
          <div className={styles.inputmain}>
            <label>ID</label>
            <input placeholder="Type your ID" />
          </div>
        </div>
      </form>
      <div className={styles.inputBot}>
        <div className={styles.bot}>
          <input placeholder="https://badgify.com/badge" />
          <button>COPY</button>
        </div>
        <div>
            <img></img>
        </div>
      </div>
    </div>
  );
}

export default Createbadge;
