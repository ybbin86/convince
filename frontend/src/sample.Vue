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
                "id": 1,
                "name": "무항생제 미국산 소고기 600g",
                "image": require("assets/goods/1.jpg"),
                "price": 34500,
                "cost": 23700,
                "tags": [
                    "고기땡기는날",
                    "크리스마스"
                ],
                "category_name": "소고기",
                "detail_image": "steak.img",
                "margin_max": 50.8,
                "margin_min": 25.5,
                "before_price": 35000,
                "dynamic_pricing": 1
            },
            {
                "id": 2,
                "name": "아오리 사과 1.5kg(10입내)",
                "image": require("assets/goods/2.jpeg"),
                "price": 7900,
                "cost": 5000,
                "tags": [
                    "과일먹는날",
                    "사과제철"
                ],
                "category_name": "사과",
                "detail_image": "apple.img",
                "margin_max": 50.8,
                "margin_min": 25.5,
                "before_price": 6000,
                "dynamic_pricing": 0
            },
            {
                "id": 3,
                "name": "미국산 씨없는 청포도 500g",
                "image": require("assets/goods/3.jpg"),
                "price": 10950,
                "cost": 5700,
                "tags": [
                    "과일먹는날"
                ],
                "category_name": "포도",
                "detail_image": "apple.img",
                "margin_max": 30.8,
                "margin_min": 22.5,
                "before_price": 10950,
                "dynamic_pricing": 1
            }
        ]
    },
    chartData: {
        "data": [
            45000,
            30000,
            82721,
            85743,
            25083,
            23217,
            72406,
            84716,
            11357,
            70336,
            71258,
            46755,
            57527,
            12024,
            83703,
            21266,
            87803,
            41510,
            60761,
            86522,
            48364,
            60416,
            34174,
            67110,
            74370,
            83447,
            15454,
            36370,
            80824,
            51556,
            81516,
            67028,
            22014,
            78654,
            41450,
            15340,
            43106,
            22480,
            46082,
            12883,
            35477,
            21275,
            34006,
            44000,
            43336,
            27800,
            77135,
            54023,
            55003,
            44756,
            36205,
            26367,
            72825,
            71131,
            12114,
            74463,
            18228,
            17574,
            13483,
            27268,
            33410,
            66457,
            53035,
            62218,
            24582,
            12828,
            40620,
            62138,
            45256,
            77737,
            16215,
            18344,
            36426,
            18783,
            70558,
            56336,
            43486,
            83312,
            82100,
            12381,
            74774,
            72557,
            35326,
            28452,
            81105,
            64021,
            26760,
            26742,
            57423,
            72562,
            43488,
            33758,
            35543,
            73244,
            70584,
            43730,
            74382,
            74282,
            75731,
            87055,
            40882,
            42771,
            73736,
            65530,
            81275,
            51233,
            20604,
            51875,
            17548,
            71500,
            18251,
            54738,
            56848,
            11680,
            45340,
            48755,
            76887,
            13020,
            83066,
            85854,
            86720,
            15213,
            67428,
            11615,
            44185,
            70285,
            31361,
            23144,
            17643,
            46212,
            45034,
            86316,
            67126,
            38108,
            34736,
            62783,
            42710,
            23415,
            51470,
            64450,
            34321,
            13866,
            16165,
            34287,
            31345,
            74318,
            26675,
            85287,
            32110,
            28856,
            25518,
            50556,
            66254,
            57537,
            76061,
            56040,
            78770,
            76836,
            58063,
            66464,
            12300,
            27528,
            64507,
            88042,
            26805,
            50038,
            45177,
            27515,
            32520,
            64227
        ],
        "label": [
            "2022-08-16 00:00:00",
            "2022-08-16 01:00:00",
            "2022-08-16 02:00:00",
            "2022-08-16 03:00:00",
            "2022-08-16 04:00:00",
            "2022-08-16 05:00:00",
            "2022-08-16 06:00:00",
            "2022-08-16 07:00:00",
            "2022-08-16 08:00:00",
            "2022-08-16 09:00:00",
            "2022-08-16 10:00:00",
            "2022-08-16 11:00:00",
            "2022-08-16 12:00:00",
            "2022-08-16 13:00:00",
            "2022-08-16 14:00:00",
            "2022-08-16 15:00:00",
            "2022-08-16 16:00:00",
            "2022-08-16 17:00:00",
            "2022-08-16 18:00:00",
            "2022-08-16 19:00:00",
            "2022-08-16 20:00:00",
            "2022-08-16 21:00:00",
            "2022-08-16 22:00:00",
            "2022-08-16 23:00:00",
            "2022-08-17 00:00:00",
            "2022-08-17 01:00:00",
            "2022-08-17 02:00:00",
            "2022-08-17 03:00:00",
            "2022-08-17 04:00:00",
            "2022-08-17 05:00:00",
            "2022-08-17 06:00:00",
            "2022-08-17 07:00:00",
            "2022-08-17 08:00:00",
            "2022-08-17 09:00:00",
            "2022-08-17 10:00:00",
            "2022-08-17 11:00:00",
            "2022-08-17 12:00:00",
            "2022-08-17 13:00:00",
            "2022-08-17 14:00:00",
            "2022-08-17 15:00:00",
            "2022-08-17 16:00:00",
            "2022-08-17 17:00:00",
            "2022-08-17 18:00:00",
            "2022-08-17 19:00:00",
            "2022-08-17 20:00:00",
            "2022-08-17 21:00:00",
            "2022-08-17 22:00:00",
            "2022-08-17 23:00:00",
            "2022-08-18 00:00:00",
            "2022-08-18 01:00:00",
            "2022-08-18 02:00:00",
            "2022-08-18 03:00:00",
            "2022-08-18 04:00:00",
            "2022-08-18 05:00:00",
            "2022-08-18 06:00:00",
            "2022-08-18 07:00:00",
            "2022-08-18 08:00:00",
            "2022-08-18 09:00:00",
            "2022-08-18 10:00:00",
            "2022-08-18 11:00:00",
            "2022-08-18 12:00:00",
            "2022-08-18 13:00:00",
            "2022-08-18 14:00:00",
            "2022-08-18 15:00:00",
            "2022-08-18 16:00:00",
            "2022-08-18 17:00:00",
            "2022-08-18 18:00:00",
            "2022-08-18 19:00:00",
            "2022-08-18 20:00:00",
            "2022-08-18 21:00:00",
            "2022-08-18 22:00:00",
            "2022-08-18 23:00:00",
            "2022-08-19 00:00:00",
            "2022-08-19 01:00:00",
            "2022-08-19 02:00:00",
            "2022-08-19 03:00:00",
            "2022-08-19 04:00:00",
            "2022-08-19 05:00:00",
            "2022-08-19 06:00:00",
            "2022-08-19 07:00:00",
            "2022-08-19 08:00:00",
            "2022-08-19 09:00:00",
            "2022-08-19 10:00:00",
            "2022-08-19 11:00:00",
            "2022-08-19 12:00:00",
            "2022-08-19 13:00:00",
            "2022-08-19 14:00:00",
            "2022-08-19 15:00:00",
            "2022-08-19 16:00:00",
            "2022-08-19 17:00:00",
            "2022-08-19 18:00:00",
            "2022-08-19 19:00:00",
            "2022-08-19 20:00:00",
            "2022-08-19 21:00:00",
            "2022-08-19 22:00:00",
            "2022-08-19 23:00:00",
            "2022-08-20 00:00:00",
            "2022-08-20 01:00:00",
            "2022-08-20 02:00:00",
            "2022-08-20 03:00:00",
            "2022-08-20 03:59:59",
            "2022-08-20 04:59:59",
            "2022-08-20 05:59:59",
            "2022-08-20 06:59:59",
            "2022-08-20 07:59:59",
            "2022-08-20 08:59:59",
            "2022-08-20 09:59:59",
            "2022-08-20 10:59:59",
            "2022-08-20 11:59:59",
            "2022-08-20 12:59:59",
            "2022-08-20 13:59:59",
            "2022-08-20 14:59:59",
            "2022-08-20 15:59:59",
            "2022-08-20 16:59:59",
            "2022-08-20 17:59:59",
            "2022-08-20 18:59:59",
            "2022-08-20 19:59:59",
            "2022-08-20 20:59:59",
            "2022-08-20 21:59:59",
            "2022-08-20 22:59:59",
            "2022-08-20 23:59:59",
            "2022-08-21 00:59:59",
            "2022-08-21 01:59:59",
            "2022-08-21 02:59:59",
            "2022-08-21 03:59:59",
            "2022-08-21 04:59:59",
            "2022-08-21 05:59:59",
            "2022-08-21 06:59:59",
            "2022-08-21 07:59:59",
            "2022-08-21 08:59:59",
            "2022-08-21 09:59:59",
            "2022-08-21 10:59:59",
            "2022-08-21 11:59:59",
            "2022-08-21 12:59:59",
            "2022-08-21 13:59:59",
            "2022-08-21 14:59:59",
            "2022-08-21 15:59:59",
            "2022-08-21 16:59:59",
            "2022-08-21 17:59:59",
            "2022-08-21 18:59:59",
            "2022-08-21 19:59:59",
            "2022-08-21 20:59:59",
            "2022-08-21 21:59:59",
            "2022-08-21 22:59:59",
            "2022-08-21 23:59:59",
            "2022-08-22 00:59:59",
            "2022-08-22 01:59:59",
            "2022-08-22 02:59:59",
            "2022-08-22 03:59:59",
            "2022-08-22 04:59:59",
            "2022-08-22 05:59:59",
            "2022-08-22 06:59:59",
            "2022-08-22 07:59:59",
            "2022-08-22 08:59:59",
            "2022-08-22 09:59:59",
            "2022-08-22 10:59:59",
            "2022-08-22 11:59:59",
            "2022-08-22 12:59:59",
            "2022-08-22 13:59:59",
            "2022-08-22 14:59:59",
            "2022-08-22 15:59:59",
            "2022-08-22 16:59:59",
            "2022-08-22 17:59:59",
            "2022-08-22 18:59:59",
            "2022-08-22 19:59:59",
            "2022-08-22 20:59:59",
            "2022-08-22 21:59:59",
            "2022-08-22 22:59:59",
            "2022-08-22 23:59:59",
            "2022-08-23 00:59:59",
        ]
    }
}