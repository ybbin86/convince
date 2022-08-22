import pickle

def load_transform():
    return pickle.load(open('/home/ubuntu/yb/src/core/transformer.pkl', 'rb'))

def load_model():
    return pickle.load(open('/home/ubuntu/yb/src/core/new_price.pkl', 'rb'))