from bson import ObjectId
from typing import Optional
from pydantic import BaseModel

__all__ = ["PyObjectId"]


def to_snake_case(string: str) -> str:
    string = "".join(word.capitalize() for word in string.split("_"))
    return string[0].lower() + string[1:]

class NewPrice(BaseModel):
    max_margin: float = ...
    min_margin: float = ...
    category: str = ...
    cost: int = ...