import { Note, XClose } from '../../data/Icon';
import styles from '../module/Modal.module.css';
function Modal({setModal}) {
  const closeHandler = () => {
    setModal(false)
  }
  return (
    <div className={styles.container}>
      <div className={styles.modal}>
        <div className={styles.modalBox}>
          <div className={styles.headBox}>
            <Note />
            <h6>Create customized Badge</h6>
            <button onClick={closeHandler}><XClose/></button>
          </div>
          <div className={styles.form}>
            <div className={styles.type}>
            <label htmlFor='type'>Type</label>
            <select value="textBadge" name='badge'>
              <option value="textBadge">Text badge</option>
            </select>
            </div>
            
            <div className={styles.selectBox}>
              <div className={styles.theme}>
              <label htmlFor='theme'>Theme</label>
                <select name='theme'>
                <option value="" disabled selected hidden>Select a theme</option>
              </select>  
              </div>
              <div className={styles.size}>
              <label htmlFor='size'>Size</label>
                <select value="textBadge" name='badge'>
                <option value="" disabled selected hidden>Select a size</option>
            </select>
            </div>
            
            </div>
            <div className={styles.inputBox}>
              <div className={styles.backgournd}>
                <label>Background</label>
                <input placeholder='#000' />
              </div>
              <div className={styles.textColor}>
                <label>Text Color</label>
                <input placeholder='#fff' />

              </div>
            
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Modal
