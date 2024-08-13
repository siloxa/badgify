import { useState } from 'react';
import styles from '../module/SideBar.module.css'
function SideBar() {
  const [selectedCategory,setSelectedCategory]= useState(null)
  const categories = [
    { id: 1, type: "Social" },
    { id: 2, type: "Build" },
    { id: 3, type: "Code Coverage" },
    { id: 4, type: "Test Results" },
    { id: 5, type: "Analysis" },
    { id: 6, type: "Chat" },
    { id: 7, type: "Dependencies" },
    { id: 8, type: "Size" },
    { id: 9, type: "Downloads" },
  ];
  
  const categoryHandler = (event) => {
    const category  = event.target.innerText;
    console.log(category)
    setSelectedCategory(category);
    
  }
  return (
    <div className={styles.sidebar}>
      <ul  onClick={categoryHandler}>
        {categories.map((i) => (
          <>
            <div className={styles.sideBox}>
            <li key={i.id} className={i.type == selectedCategory ? styles.selected : null}>{i.type}</li>
            </div>
          </>
        ) )}
      </ul>
    </div>
  )
}

export default SideBar
