# TODO

- [ ] **_Albert_** Simplify request model
- [ ] Companion Planting
- [x] Parse data from when2plant.uk

```js
let data = {}
Array.from(document.getElementsByTagName('table')[0].getElementsByTagName('tr')).map(tr => Array.from(tr.getElementsByTagName('td')).map(td => {
  if(td.innerText.replace(/\s/g, '').length > 0) {
    return td.innerText
  } else if(td.getAttribute('bgcolor')) {
    return td.getAttribute('bgcolor')
  } else {
    return td
  }
}))[0]
```