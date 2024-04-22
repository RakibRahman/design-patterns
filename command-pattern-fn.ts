type CommandFunction<State> = (state: State) => [State, (state: State) => State];


function createCommandStack<State>(state: State) {
    const stack: ((state: State) => State)[] = [];
    let _state = state;

    return {

        execute(command: CommandFunction<State>) {
            const [newState, undoFunction] = command(_state);

            _state = newState;
            stack.push(undoFunction);
            return _state;

        },
        undo() {
            const command = stack.pop();
            if (command) {
                _state = command(_state);
            }
            return _state;
        }
    }
}


const addOne: CommandFunction<number> = (state) => [state + 1, (state) => state - 1];

const commandStack = createCommandStack(40);

console.log(commandStack.execute(addOne))
console.log(commandStack.execute(addOne))
console.log(commandStack.undo());


const substractOne: CommandFunction<number> = (state) => [state - 1, (state) => state + 1];

const cs = createCommandStack(78);
console.log(cs.execute(substractOne))

const createSetValue = (value: number): CommandFunction<number> => {

    return (state) => {
        const _originalState = state;
        return [value, () => _originalState]
    }
}


const setTo42 = createSetValue(79);
console.log(cs.execute(setTo42));
