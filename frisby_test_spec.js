var frisby = require('frisby');
frisby.create('Post a pet')
  .post('http://petstore.swagger.io/v2/pet', {
     id: 0,
     category: {
      id: 0,
      name: "string"
    },
    name: "doggie",
    photoUrls: [
      "string"
    ],
    tags: [
    {
      id: 0,
      name: "string"
    }
    ],
    status: "available"
  })
  .expectStatus(415)
  .expectHeaderContains('content-type', 'application/xml')
  .expectJSON('0', {
    id: 43534543537731,
    category: {
    id: 0,
    name: "string"
  },
  name: "doggie",
  photoUrls: [
    "string"
  ],
  tags: [
    {
      id: 0,
      name: "string"
    }
  ],
  status: "available"
  })
.toss();