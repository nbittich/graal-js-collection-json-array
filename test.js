class Script {

  process(eventStr) {
    const event = JSON.parse(eventStr);
    randomService.randomStuffList(event.randomUuids); // works
    randomService.randomStuffCollection(event.randomUuids); // fails
  }
}
