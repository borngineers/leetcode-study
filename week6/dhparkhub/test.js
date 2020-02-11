let startTime;
const A = () => 0;
const B = () => 0;

startTime = Date.now();
for (let i=0; i<1000000000; i++) {
  A();
}
for (let i=0; i<1000000000; i++) {
  B();
}
console.log(`duration: ${Date.now() - startTime}`);

startTime = Date.now();
for (let i=0; i<1000000000; i++) {
  A();
  B();
}
console.log(`duration: ${Date.now() - startTime}`);
