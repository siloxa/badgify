import React from 'react';
import styles from './maininput.module.css';
function MainInput() {
  return (
    <div className={styles.maininpute}>
      <div className={styles.inputTop}>
        <div className={styles.topLeft}>
          <label for="icon">Icon</label>
          <select name="icons" id="cars">
            <option value="github">Github</option>
          </select>
        </div>
        <div className={styles.topLeft}>
          <label for="icon">Text</label>
          <input type="text" placeholder="Badgify" />
        </div>
      </div>
      <div className={styles.inputTop}>
        <div className={styles.topLeft}>
          <div className={styles.topLeft}>
            <label for="icon">Background color</label>
            <input type="text" placeholder="#000000" />
          </div>
        </div>
        <div className={styles.topLeft}>
          <label for="icon">Text color</label>
          <input type="text" placeholder="#ffffff" />
        </div>
      </div>
      <div className={styles.badgContain}>
        <div className={styles.badg}>
          <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" viewBox="0 0 25 25" fill="none">
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M12.5 2.7467C6.975 2.7467 2.5 7.2217 2.5 12.7467C2.5 17.1717 5.3625 20.9092 9.3375 22.2342C9.8375 22.3217 10.025 22.0217 10.025 21.7592C10.025 21.5217 10.0125 20.7342 10.0125 19.8967C7.5 20.3592 6.85 19.2842 6.65 18.7217C6.5375 18.4342 6.05 17.5467 5.625 17.3092C5.275 17.1217 4.775 16.6592 5.6125 16.6467C6.4 16.6342 6.9625 17.3717 7.15 17.6717C8.05 19.1842 9.4875 18.7592 10.0625 18.4967C10.15 17.8467 10.4125 17.4092 10.7 17.1592C8.475 16.9092 6.15 16.0467 6.15 12.2217C6.15 11.1342 6.5375 10.2342 7.175 9.5342C7.075 9.2842 6.725 8.2592 7.275 6.8842C7.275 6.8842 8.1125 6.6217 10.025 7.9092C10.825 7.6842 11.675 7.5717 12.525 7.5717C13.375 7.5717 14.225 7.6842 15.025 7.9092C16.9375 6.6092 17.775 6.8842 17.775 6.8842C18.325 8.2592 17.975 9.2842 17.875 9.5342C18.5125 10.2342 18.9 11.1217 18.9 12.2217C18.9 16.0592 16.5625 16.9092 14.3375 17.1592C14.7 17.4717 15.0125 18.0717 15.0125 19.0092C15.0125 20.3467 15 21.4217 15 21.7592C15 22.0217 15.1875 22.3342 15.6875 22.2342C17.6727 21.564 19.3977 20.2882 20.6198 18.5862C21.8419 16.8843 22.4995 14.842 22.5 12.7467C22.5 7.2217 18.025 2.7467 12.5 2.7467Z"
              fill="white"
            />
          </svg>
          <p>Badgify</p>
        </div>
      </div>
      <div className={styles.inputBtn}>
        <input placeholder='https://badgify.com/badge'/>
        <button>COPY</button>
      </div>
    </div>
  );
}

export default MainInput;
