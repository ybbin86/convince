export default
{
    hashtagList: [
        {
            "createdTime": "2022-08-20 20:38:22",
            "updatedTime": "2022-08-20 20:38:22",
            "id": 1,
            "name": "사과제철",
            "startDate": "2022-12-31",
            "endDate": "2022-12-25"
        },
        {
            "createdTime": "2022-08-20 20:38:33",
            "updatedTime": "2022-08-20 20:38:33",
            "id": 2,
            "name": "기념일",
            "startDate": "2022-12-31",
            "endDate": "2022-12-25"
        }
    ]
    ,categoryList1 : [
        {
            "createdTime": "2022-08-20 17:07:05",
            "updatedTime": "2022-08-20 17:07:05",
            "id": 1,
            "name": "야채/채소 ",
            "depth": 1,
            "parentId": 0
        },
        {
            "createdTime": "2022-08-20 17:07:17",
            "updatedTime": "2022-08-20 17:07:17",
            "id": 2,
            "name": "육류/계란",
            "depth": 1,
            "parentId": 0
        }
    ],
    categoryList2 : [
        {
            "createdTime": "2022-08-20 17:07:31",
            "updatedTime": "2022-08-20 17:07:31",
            "id": 3,
            "name": "소고기",
            "depth": 2,
            "parentId": 2
        },
        {
            "createdTime": "2022-08-20 17:19:35",
            "updatedTime": "2022-08-20 17:19:35",
            "id": 4,
            "name": "사과",
            "depth": 2,
            "parentId": 1
        }
    ],
    goodsList: {
        "total": 3,
        "size": 5,
        "data": [
            {
                "name": "무항생제 미국산 소고기 600g",
                "image": require("assets/goods/1.jpg"),
                "price": 34500,
                "tags": [
                    "고기땡기는날",
                    "크리스마스"
                ]
            },
            {
                "name": "아오리 사과 1.5kg(10입내)",
                "image": require("assets/goods/2.jpeg"),
                "price": 7900,
                "tags": [
                    "과일먹는날",
                    "사과제철"
                ]
            },
            {
                "name": "미국산 씨없는 청포도 500g",
                "image": require("assets/goods/3.jpg"),
                "price": 10950,
                "tags": [
                    "과일먹는날"
                ]
            }
        ]
    }
}