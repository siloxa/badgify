import React, { useState } from 'react';
import styles from './createbadge.module.css';
import rectangle from '../../assets/image/Rectangle27.png'

function Createbadge() {
  const [selectedItem, setSelectedItem] = useState('Lable badge');
  const getSelectedHandler = event => {
    setSelectedItem(event.target.value);
  };
  return (
    <div className={styles.container}>
      <form className={styles.form}>
        <div className={styles.inputcon}>
          <div className={styles.inputmain}>
            <label>Type</label>
            <select name="Type" onChange={getSelectedHandler} value={selectedItem}>
              <option value="Lable badge">Lable badge</option>
              <option value="Text badge">Text badge</option>
              <option value="Icon badge">Icon badge</option>
            </select>
          </div>
          <div className={styles.inputmain}>
            <label>Theme</label>
            <select></select>
          </div>
        </div>
        {selectedItem === 'Lable badge' && (
          <>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Size</label>
                <input className={styles.inputs} placeholder="Type hex code or color’s name" />
              </div>
              <div className={styles.inputmain}>
                <label>Title</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Background Color</label>
                <input className={styles.inputs} placeholder="Type hex code or color’s name" />
              </div>
              <div className={styles.inputmain}>
                <label>Text Color</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Theme</label>
                <select></select>
              </div>
              <div className={styles.inputmain}>
                <label>Text Color</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
          </>
        )}
        {selectedItem === 'Text badge' && (
          <>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Type</label>
                <select name="Type">
                  <option value="Lable badge">Lable badge</option>
                  <option value="Text badge">Text badge</option>
                  <option value="Icon badge">Icon badge</option>
                </select>
              </div>
              <div className={styles.inputmain}>
                <label>Theme</label>
                <select></select>
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Background Color</label>
                <input className={styles.inputs} placeholder="Type hex code or color’s name" />
              </div>
              <div className={styles.inputmain}>
                <label>Text Color</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Size</label>
                <select></select>
              </div>
              <div className={styles.inputmain}>
                <label>Link</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
          </>
        )}
        {selectedItem === 'Icon badge' && (
          <>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Type</label>
                <select name="Type" onChange={getSelectedHandler} value={selectedItem}>
                  <option value="Lable badge">Lable badge</option>
                  <option value="Text badge">Text badge</option>
                  <option value="Icon badge">Icon badge</option>
                </select>
              </div>
              <div className={styles.inputmain}>
                <label>Theme</label>
                <select></select>
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Theme</label>
                <select></select>
              </div>
              <div className={styles.inputmain}>
                <label>Theme</label>
                <select></select>
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Background Color</label>
                <input className={styles.inputs} placeholder="Type hex code or color’s name" />
              </div>
              <div className={styles.inputmain}>
                <label>Text Color</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
            <div className={styles.inputcon}>
              <div className={styles.inputmain}>
                <label>Text Color</label>
                <input className={styles.inputs} placeholder="Type your ID" />
              </div>
            </div>
          </>
        )}
      </form>
      <div className={styles.inputBot}>
          <img src={rectangle} />
        <div className={styles.bot}>
          <input placeholder="https://badgify.com/badge" />
          <button>COPY</button>
        </div>
      </div>
    </div>
  );
}

export default Createbadge;
