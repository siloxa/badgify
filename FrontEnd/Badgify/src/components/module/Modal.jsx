import { Note, XClose } from '../../data/Icon';
import styles from '../module/Modal.module.css';
import rectangle from '../../assets/image/Rectangle.jpg'
import { useState } from 'react';
function Modal({ setModal }) {
  
  const [selectedOption,setSelectedOption]=useState("textBadge")
  const closeHandler = () => {
    setModal(false);
  };
  const selectHandler = (event) => {
    setSelectedOption(event.target.value);
  }
  return (
    <div className={styles.container}>
      <div className={styles.modal}>
        <div className={styles.modalBox}>
          <div className={styles.headBox}>
            <Note />
            <h6>Create customized Badge</h6>
            <button onClick={closeHandler}>
              <XClose />
            </button>
          </div>
          <div className={styles.form}>
            <div className={styles.type}>
              <label htmlFor="type">Type</label>
              <select value={selectedOption} name="badge" onChange={selectHandler}>
                <option value="textBadge">Text badge</option>
                <option value="iconBadge">Icon badge</option>
                <option value="labelBadge">Lable badge</option>
              </select>
            </div>

            <div className={styles.selectBox}>
              <div className={styles.theme}>
                <label htmlFor="theme">Theme</label>
                <select name="theme">
                  <option value="" disabled selected hidden>
                    Select a theme
                  </option>
                </select>
              </div>
              <div className={styles.size}>
                <label htmlFor="size">Size</label>
                <select value="textBadge" name="badge">
                  <option value="" disabled selected hidden>
                    Select a size
                  </option>
                </select>
              </div>
            </div>
            <div className={styles.inputBox}>
              <div className={styles.backgournd}>
                <label>Background</label>
                <input placeholder="#000" />
              </div>
              <div className={styles.textColor}>
                <label>Text Color</label>
                <input placeholder="#fff" />
              </div>
            </div>
            <div className={styles.inputBox}>
              {selectedOption === "textBadge" && (
                <>
                <div>
                <label>Link</label>
                <input placeholder="Type your link" />
              </div>
              <div>
                <label>Text</label>
                <input placeholder="type your text" />
              </div>
                </>
              )}
              {
                selectedOption === "iconBadge" && (
                  <>
                  <div>
                <label>Link</label>
                <input placeholder="Type your link" />
                    </div>
                    <div>
                <label htmlFor="icon">Icon</label>
                <select name="icon">
                  <option value="" disabled selected hidden></option>
                </select>
              </div>
                  </>
                )
              }
              {selectedOption === "labelBadge" && (
                <>
                  
                <div>
                <label>Link</label>
                <input placeholder="Type your link" />
              </div>
              <div>
                <label>Text</label>
                <input placeholder="type your text" />
                  </div>
                </>
                
              )}
              
            </div>
            {selectedOption === "labelBadge" && (
                <div>
                <label htmlFor="icon">Icon</label>
                <select name="icon">
                  <option value="" disabled selected hidden></option>
                </select>
              </div>
              )}
            <div className={styles.bottom}>
              <img src={rectangle} />
              <div className={styles.inputBtn}>
                <input placeholder='https://badgify.com/badge' />
                <button>COPY</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Modal;
