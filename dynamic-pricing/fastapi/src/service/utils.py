import pickle

def load_transform(path):
    return pickle.load(open(path, 'rb'))

def load_model(path):
    return pickle.load(open(path, 'rb'))